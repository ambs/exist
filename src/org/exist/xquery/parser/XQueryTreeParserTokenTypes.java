// $ANTLR 2.7.7 (2006-11-01): "XQueryTree.g" -> "XQueryTreeParser.java"$

	package org.exist.xquery.parser;

	import antlr.debug.misc.*;
	import java.io.StringReader;
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Set;
	import java.util.TreeSet;
	import java.util.HashMap;
	import java.util.Stack;
	import org.exist.storage.BrokerPool;
	import org.exist.storage.DBBroker;
	import org.exist.storage.analysis.Tokenizer;
	import org.exist.EXistException;
	import org.exist.Namespaces;
	import org.exist.dom.DocumentSet;
	import org.exist.dom.DocumentImpl;
	import org.exist.dom.QName;
	import org.exist.security.PermissionDeniedException;
	import org.exist.util.XMLChar;
	import org.exist.xquery.*;
	import org.exist.xquery.value.*;
	import org.exist.xquery.functions.fn.*;
	import org.exist.xquery.update.*;
	import org.exist.storage.ElementValue;

public interface XQueryTreeParserTokenTypes {
	int EOF = 1;
	int NULL_TREE_LOOKAHEAD = 3;
	int QNAME = 4;
	int PREDICATE = 5;
	int FLWOR = 6;
	int PARENTHESIZED = 7;
	int ABSOLUTE_SLASH = 8;
	int ABSOLUTE_DSLASH = 9;
	int WILDCARD = 10;
	int PREFIX_WILDCARD = 11;
	int FUNCTION = 12;
	int DYNAMIC_FCALL = 13;
	int UNARY_MINUS = 14;
	int UNARY_PLUS = 15;
	int XPOINTER = 16;
	int XPOINTER_ID = 17;
	int VARIABLE_REF = 18;
	int VARIABLE_BINDING = 19;
	int ELEMENT = 20;
	int ATTRIBUTE = 21;
	int ATTRIBUTE_CONTENT = 22;
	int TEXT = 23;
	int VERSION_DECL = 24;
	int NAMESPACE_DECL = 25;
	int DEF_NAMESPACE_DECL = 26;
	int DEF_COLLATION_DECL = 27;
	int DEF_FUNCTION_NS_DECL = 28;
	int ANNOT_DECL = 29;
	int GLOBAL_VAR = 30;
	int FUNCTION_DECL = 31;
	int FUNCTION_INLINE = 32;
	int PROLOG = 33;
	int OPTION = 34;
	int ATOMIC_TYPE = 35;
	int MODULE = 36;
	int ORDER_BY = 37;
	int GROUP_BY = 38;
	int POSITIONAL_VAR = 39;
	int CATCH_ERROR_CODE = 40;
	int CATCH_ERROR_DESC = 41;
	int CATCH_ERROR_VAL = 42;
	int MODULE_DECL = 43;
	int MODULE_IMPORT = 44;
	int SCHEMA_IMPORT = 45;
	int ATTRIBUTE_TEST = 46;
	int COMP_ELEM_CONSTRUCTOR = 47;
	int COMP_ATTR_CONSTRUCTOR = 48;
	int COMP_TEXT_CONSTRUCTOR = 49;
	int COMP_COMMENT_CONSTRUCTOR = 50;
	int COMP_PI_CONSTRUCTOR = 51;
	int COMP_NS_CONSTRUCTOR = 52;
	int COMP_DOC_CONSTRUCTOR = 53;
	int PRAGMA = 54;
	int GTEQ = 55;
	int SEQUENCE = 56;
	int LITERAL_xpointer = 57;
	int LPAREN = 58;
	int RPAREN = 59;
	int NCNAME = 60;
	int LITERAL_xquery = 61;
	int LITERAL_version = 62;
	int SEMICOLON = 63;
	int LITERAL_module = 64;
	int LITERAL_namespace = 65;
	int EQ = 66;
	int STRING_LITERAL = 67;
	int LITERAL_declare = 68;
	int LITERAL_default = 69;
	// "boundary-space" = 70
	int LITERAL_ordering = 71;
	int LITERAL_construction = 72;
	// "base-uri" = 73
	// "copy-namespaces" = 74
	int LITERAL_option = 75;
	int LITERAL_function = 76;
	int LITERAL_variable = 77;
	int MOD = 78;
	int LITERAL_import = 79;
	int LITERAL_encoding = 80;
	int LITERAL_collation = 81;
	int LITERAL_element = 82;
	int LITERAL_order = 83;
	int LITERAL_empty = 84;
	int LITERAL_greatest = 85;
	int LITERAL_least = 86;
	int LITERAL_preserve = 87;
	int LITERAL_strip = 88;
	int LITERAL_ordered = 89;
	int LITERAL_unordered = 90;
	int COMMA = 91;
	// "no-preserve" = 92
	int LITERAL_inherit = 93;
	// "no-inherit" = 94
	int DOLLAR = 95;
	int LCURLY = 96;
	int RCURLY = 97;
	int COLON = 98;
	int LITERAL_external = 99;
	int LITERAL_schema = 100;
	// ":" = 101
	int LITERAL_as = 102;
	int LITERAL_at = 103;
	// "empty-sequence" = 104
	int QUESTION = 105;
	int STAR = 106;
	int PLUS = 107;
	int LITERAL_item = 108;
	int LITERAL_for = 109;
	int LITERAL_let = 110;
	int LITERAL_try = 111;
	int LITERAL_some = 112;
	int LITERAL_every = 113;
	int LITERAL_if = 114;
	int LITERAL_switch = 115;
	int LITERAL_typeswitch = 116;
	int LITERAL_update = 117;
	int LITERAL_replace = 118;
	int LITERAL_value = 119;
	int LITERAL_insert = 120;
	int LITERAL_delete = 121;
	int LITERAL_rename = 122;
	int LITERAL_with = 123;
	int LITERAL_into = 124;
	int LITERAL_preceding = 125;
	int LITERAL_following = 126;
	int LITERAL_catch = 127;
	int UNION = 128;
	int LITERAL_where = 129;
	int LITERAL_return = 130;
	int LITERAL_in = 131;
	int LITERAL_by = 132;
	int LITERAL_stable = 133;
	int LITERAL_ascending = 134;
	int LITERAL_descending = 135;
	int LITERAL_group = 136;
	int LITERAL_satisfies = 137;
	int LITERAL_case = 138;
	int LITERAL_then = 139;
	int LITERAL_else = 140;
	int LITERAL_or = 141;
	int LITERAL_and = 142;
	int LITERAL_instance = 143;
	int LITERAL_of = 144;
	int LITERAL_treat = 145;
	int LITERAL_castable = 146;
	int LITERAL_cast = 147;
	int BEFORE = 148;
	int AFTER = 149;
	int LITERAL_eq = 150;
	int LITERAL_ne = 151;
	int LITERAL_lt = 152;
	int LITERAL_le = 153;
	int LITERAL_gt = 154;
	int LITERAL_ge = 155;
	int GT = 156;
	int NEQ = 157;
	int LT = 158;
	int LTEQ = 159;
	int LITERAL_is = 160;
	int LITERAL_isnot = 161;
	int ANDEQ = 162;
	int OREQ = 163;
	int CONCAT = 164;
	int LITERAL_to = 165;
	int MINUS = 166;
	int LITERAL_div = 167;
	int LITERAL_idiv = 168;
	int LITERAL_mod = 169;
	int PRAGMA_START = 170;
	int PRAGMA_END = 171;
	int LITERAL_union = 172;
	int LITERAL_intersect = 173;
	int LITERAL_except = 174;
	int SLASH = 175;
	int DSLASH = 176;
	int LITERAL_text = 177;
	int LITERAL_node = 178;
	int LITERAL_attribute = 179;
	int LITERAL_comment = 180;
	// "processing-instruction" = 181
	// "document-node" = 182
	int LITERAL_document = 183;
	int HASH = 184;
	int SELF = 185;
	int XML_COMMENT = 186;
	int XML_PI = 187;
	int LPPAREN = 188;
	int RPPAREN = 189;
	int AT = 190;
	int PARENT = 191;
	int LITERAL_child = 192;
	int LITERAL_self = 193;
	int LITERAL_descendant = 194;
	// "descendant-or-self" = 195
	// "following-sibling" = 196
	int LITERAL_parent = 197;
	int LITERAL_ancestor = 198;
	// "ancestor-or-self" = 199
	// "preceding-sibling" = 200
	int DOUBLE_LITERAL = 201;
	int DECIMAL_LITERAL = 202;
	int INTEGER_LITERAL = 203;
	// "schema-element" = 204
	int END_TAG_START = 205;
	int QUOT = 206;
	int APOS = 207;
	int QUOT_ATTRIBUTE_CONTENT = 208;
	int ESCAPE_QUOT = 209;
	int APOS_ATTRIBUTE_CONTENT = 210;
	int ESCAPE_APOS = 211;
	int ELEMENT_CONTENT = 212;
	int XML_COMMENT_END = 213;
	int XML_PI_END = 214;
	int XML_CDATA = 215;
	int LITERAL_collection = 216;
	int LITERAL_validate = 217;
	int XML_PI_START = 218;
	int XML_CDATA_START = 219;
	int XML_CDATA_END = 220;
	int LETTER = 221;
	int DIGITS = 222;
	int HEX_DIGITS = 223;
	int NMSTART = 224;
	int NMCHAR = 225;
	int WS = 226;
	int EXPR_COMMENT = 227;
	int PREDEFINED_ENTITY_REF = 228;
	int CHAR_REF = 229;
	int S = 230;
	int NEXT_TOKEN = 231;
	int CHAR = 232;
	int BASECHAR = 233;
	int IDEOGRAPHIC = 234;
	int COMBINING_CHAR = 235;
	int DIGIT = 236;
	int EXTENDER = 237;
}
