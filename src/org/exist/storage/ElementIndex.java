
/* eXist xml document repository and xpath implementation
 * Copyright (C) 2001,  Wolfgang M. Meier (wolfgang@exist-db.org)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.exist.storage;

import java.util.Observable;
import java.util.TreeMap;

import org.exist.collections.Collection;
import org.exist.dom.DocumentImpl;
import org.exist.dom.DocumentSet;
import org.exist.dom.NodeSet;
import org.exist.dom.QName;
import org.exist.security.PermissionDeniedException;
import org.exist.util.Occurrences;
import org.exist.xquery.NodeSelector;

/** base class for {@link org.exist.storage.NativeElementIndex} */
public abstract class ElementIndex extends Observable {

    /** The broker that is using this value index */
    protected DBBroker broker;
    
    protected TreeMap pending = new TreeMap();
    
    /** The current document */
    protected DocumentImpl doc;

    public ElementIndex(DBBroker broker) {
        this.broker = broker;
    }

    public void setDocument(DocumentImpl doc) {
        this.doc = doc;
    }
    
    /**
	 *  Returns a node set containing all the attributes matching the given QName and
	 * belonging to one of the documents in the DocumentSet.
	 *
	 */
	public abstract NodeSet findElementsByTagName(byte type, DocumentSet docs, QName qname,	NodeSelector selector);
	
	public abstract NodeSet getAttributesByName(DocumentSet docs, QName qname, NodeSelector selector);
	
	public abstract Occurrences[] scanIndexedElements(Collection collection, boolean inclusive) 
        throws PermissionDeniedException;
	
}
