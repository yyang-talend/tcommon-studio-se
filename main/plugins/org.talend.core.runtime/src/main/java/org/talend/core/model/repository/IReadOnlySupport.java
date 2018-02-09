// ============================================================================
//
// Copyright (C) 2006-2018 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.core.model.repository;


/**
 * created by cmeng on Dec 27, 2016
 * Detailled comment
 *
 */
public interface IReadOnlySupport {

    public boolean isReadOnly();

    public void setReadOnly(boolean readOnly);

}
