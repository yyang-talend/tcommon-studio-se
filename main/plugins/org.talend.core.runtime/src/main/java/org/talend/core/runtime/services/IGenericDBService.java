// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core.runtime.services;

import org.eclipse.swt.widgets.Composite;
import org.talend.core.IService;
import org.talend.core.model.metadata.builder.connection.Connection;
import org.talend.core.model.process.EComponentCategory;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.Property;

/**
 * DOC hwang  class global comment. Detailled comment
 */
public interface IGenericDBService extends IService{
    
    public Composite creatDBDynamicComposite(Composite composite, EComponentCategory sectionCategory,
            boolean isCompactView,Property property, String typeName);
    
    public Connection createGenericConnection();
    
    public ConnectionItem createGenericConnectionItem();
    
    public String getGenericConnectionType(Item item);
    
    public void setGenericConnectionType(String type, Item item);
    
}
