/*
 * eXist-db Open Source Native XML Database
 * Copyright (C) 2001 The eXist-db Authors
 *
 * info@exist-db.org
 * http://www.exist-db.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.exist.xmldb.function;

import org.exist.dom.persistent.DocumentImpl;
import org.exist.security.PermissionDeniedException;
import org.exist.storage.DBBroker;
import org.exist.storage.txn.Txn;
import org.exist.util.LockException;
import org.exist.util.SyntaxException;
import com.evolvedbinary.j8fu.function.TriFunctionE;
import org.xmldb.api.base.ErrorCodes;
import org.xmldb.api.base.XMLDBException;

import java.io.IOException;

/**
 * Specialisation of FunctionE which deals with
 * local XMLDB operations; Predominantly converts exceptions
 * from the database into XMLDBException types
 *
 * @author <a href="mailto:adam.retter@googlemail.com">Adam Retter</a>
 */
@FunctionalInterface
public interface LocalXmldbDocumentFunction<R> extends TriFunctionE<DocumentImpl, DBBroker, Txn, R, XMLDBException> {

    @Override
    default R apply(final DocumentImpl document, final DBBroker broker, final Txn transaction) throws XMLDBException {
        try {
            return applyXmldb(document, broker, transaction);
        } catch(final PermissionDeniedException e) {
            throw new XMLDBException(ErrorCodes.PERMISSION_DENIED, e.getMessage(), e);
        } catch(final LockException e) {
            throw new XMLDBException(ErrorCodes.COLLECTION_CLOSED, e.getMessage(), e);
        } catch(final IOException | SyntaxException e) {
            throw new XMLDBException(ErrorCodes.UNKNOWN_ERROR, e.getMessage(), e);
        }
    }

    /**
     * Signature for lambda function which takes a document.
     *
     * @param document The database collection
     * @param broker the database broker
     * @param transaction the database transaction
     *
     * @return the result of apply the function.
     *
     * @throws XMLDBException if an error occurs whilst applying the function
     * @throws PermissionDeniedException if the user has insufficient permissions
     * @throws LockException if an error occurs whilst locking a collection or document
     * @throws IOException if an IO error occurs
     * @throws SyntaxException if a syntax error occurs
     */
    R applyXmldb(final DocumentImpl document, final DBBroker broker, final Txn transaction)
            throws XMLDBException, PermissionDeniedException, LockException, IOException, SyntaxException;
}
