/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.core.model.properties.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.talend.core.model.properties.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.talend.core.model.properties.PropertiesPackage
 * @generated
 */
public class PropertiesAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static PropertiesPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PropertiesAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = PropertiesPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PropertiesSwitch modelSwitch =
        new PropertiesSwitch() {
            public Object caseProject(Project object) {
                return createProjectAdapter();
            }
            public Object caseProjectComponentAuthorisation(ProjectComponentAuthorisation object) {
                return createProjectComponentAuthorisationAdapter();
            }
            public Object caseProjectReference(ProjectReference object) {
                return createProjectReferenceAdapter();
            }
            public Object caseStatus(Status object) {
                return createStatusAdapter();
            }
            public Object caseItemState(ItemState object) {
                return createItemStateAdapter();
            }
            public Object caseProperty(Property object) {
                return createPropertyAdapter();
            }
            public Object caseItem(Item object) {
                return createItemAdapter();
            }
            public Object caseLinkDocumentationItem(LinkDocumentationItem object) {
                return createLinkDocumentationItemAdapter();
            }
            public Object caseLinkType(LinkType object) {
                return createLinkTypeAdapter();
            }
            public Object caseBusinessProcessItem(BusinessProcessItem object) {
                return createBusinessProcessItemAdapter();
            }
            public Object caseFileItem(FileItem object) {
                return createFileItemAdapter();
            }
            public Object caseByteArray(ByteArray object) {
                return createByteArrayAdapter();
            }
            public Object caseDocumentationItem(DocumentationItem object) {
                return createDocumentationItemAdapter();
            }
            public Object caseRoutineItem(RoutineItem object) {
                return createRoutineItemAdapter();
            }
            public Object caseConnectionItem(ConnectionItem object) {
                return createConnectionItemAdapter();
            }
            public Object caseSnippetVariable(SnippetVariable object) {
                return createSnippetVariableAdapter();
            }
            public Object caseSnippetItem(SnippetItem object) {
                return createSnippetItemAdapter();
            }
            public Object caseDelimitedFileConnectionItem(DelimitedFileConnectionItem object) {
                return createDelimitedFileConnectionItemAdapter();
            }
            public Object casePositionalFileConnectionItem(PositionalFileConnectionItem object) {
                return createPositionalFileConnectionItemAdapter();
            }
            public Object caseRegExFileConnectionItem(RegExFileConnectionItem object) {
                return createRegExFileConnectionItemAdapter();
            }
            public Object caseCSVFileConnectionItem(CSVFileConnectionItem object) {
                return createCSVFileConnectionItemAdapter();
            }
            public Object caseDatabaseConnectionItem(DatabaseConnectionItem object) {
                return createDatabaseConnectionItemAdapter();
            }
            public Object caseSAPConnectionItem(SAPConnectionItem object) {
                return createSAPConnectionItemAdapter();
            }
            public Object caseXmlFileConnectionItem(XmlFileConnectionItem object) {
                return createXmlFileConnectionItemAdapter();
            }
            public Object caseLdifFileConnectionItem(LdifFileConnectionItem object) {
                return createLdifFileConnectionItemAdapter();
            }
            public Object caseExcelFileConnectionItem(ExcelFileConnectionItem object) {
                return createExcelFileConnectionItemAdapter();
            }
            public Object caseEbcdicConnectionItem(EbcdicConnectionItem object) {
                return createEbcdicConnectionItemAdapter();
            }
            public Object caseProcessItem(ProcessItem object) {
                return createProcessItemAdapter();
            }
            public Object caseUserRole(UserRole object) {
                return createUserRoleAdapter();
            }
            public Object caseUser(User object) {
                return createUserAdapter();
            }
            public Object caseFolderItem(FolderItem object) {
                return createFolderItemAdapter();
            }
            public Object caseComponent(Component object) {
                return createComponentAdapter();
            }
            public Object caseNotationHolder(NotationHolder object) {
                return createNotationHolderAdapter();
            }
            public Object caseUserProjectAuthorization(UserProjectAuthorization object) {
                return createUserProjectAuthorizationAdapter();
            }
            public Object caseContextItem(ContextItem object) {
                return createContextItemAdapter();
            }
            public Object caseSpagoBiServer(SpagoBiServer object) {
                return createSpagoBiServerAdapter();
            }
            public Object caseLicense(License object) {
                return createLicenseAdapter();
            }
            public Object caseGenericSchemaConnectionItem(GenericSchemaConnectionItem object) {
                return createGenericSchemaConnectionItemAdapter();
            }
            public Object caseUserModuleAuthorization(UserModuleAuthorization object) {
                return createUserModuleAuthorizationAdapter();
            }
            public Object caseLDAPSchemaConnectionItem(LDAPSchemaConnectionItem object) {
                return createLDAPSchemaConnectionItemAdapter();
            }
            public Object caseSalesforceSchemaConnectionItem(SalesforceSchemaConnectionItem object) {
                return createSalesforceSchemaConnectionItemAdapter();
            }
            public Object caseDashboardConnection(DashboardConnection object) {
                return createDashboardConnectionAdapter();
            }
            public Object caseExecutionServer(ExecutionServer object) {
                return createExecutionServerAdapter();
            }
            public Object caseExecutionTask(ExecutionTask object) {
                return createExecutionTaskAdapter();
            }
            public Object caseExecutionTaskCmdPrm(ExecutionTaskCmdPrm object) {
                return createExecutionTaskCmdPrmAdapter();
            }
            public Object caseExecutionTaskJobPrm(ExecutionTaskJobPrm object) {
                return createExecutionTaskJobPrmAdapter();
            }
            public Object caseTaskExecutionHistory(TaskExecutionHistory object) {
                return createTaskExecutionHistoryAdapter();
            }
            public Object caseTalendTrigger(TalendTrigger object) {
                return createTalendTriggerAdapter();
            }
            public Object caseCronTalendTrigger(CronTalendTrigger object) {
                return createCronTalendTriggerAdapter();
            }
            public Object caseCronUITalendTrigger(CronUITalendTrigger object) {
                return createCronUITalendTriggerAdapter();
            }
            public Object caseSimpleTalendTrigger(SimpleTalendTrigger object) {
                return createSimpleTalendTriggerAdapter();
            }
            public Object caseExecutionVirtualServer(ExecutionVirtualServer object) {
                return createExecutionVirtualServerAdapter();
            }
            public Object caseFileTrigger(FileTrigger object) {
                return createFileTriggerAdapter();
            }
            public Object caseFileTriggerMask(FileTriggerMask object) {
                return createFileTriggerMaskAdapter();
            }
            public Object caseJobletProcessItem(JobletProcessItem object) {
                return createJobletProcessItemAdapter();
            }
            public Object caseJobDocumentationItem(JobDocumentationItem object) {
                return createJobDocumentationItemAdapter();
            }
            public Object caseJobletDocumentationItem(JobletDocumentationItem object) {
                return createJobletDocumentationItemAdapter();
            }
            public Object caseWSDLSchemaConnectionItem(WSDLSchemaConnectionItem object) {
                return createWSDLSchemaConnectionItemAdapter();
            }
            public Object caseSchemaInformation(SchemaInformation object) {
                return createSchemaInformationAdapter();
            }
            public Object caseInformation(Information object) {
                return createInformationAdapter();
            }
            public Object caseSQLPatternItem(SQLPatternItem object) {
                return createSQLPatternItemAdapter();
            }
            public Object caseComponentSetting(ComponentSetting object) {
                return createComponentSettingAdapter();
            }
            public Object caseStatAndLogsSettings(StatAndLogsSettings object) {
                return createStatAndLogsSettingsAdapter();
            }
            public Object caseImplicitContextSettings(ImplicitContextSettings object) {
                return createImplicitContextSettingsAdapter();
            }
            public Object caseSoaOperation(SoaOperation object) {
                return createSoaOperationAdapter();
            }
            public Object caseSoaInputParameter(SoaInputParameter object) {
                return createSoaInputParameterAdapter();
            }
            public Object caseSoaService(SoaService object) {
                return createSoaServiceAdapter();
            }
            public Object caseRulesItem(RulesItem object) {
                return createRulesItemAdapter();
            }
            public Object caseUserRight(UserRight object) {
                return createUserRightAdapter();
            }
            public Object caseRoleRight(RoleRight object) {
                return createRoleRightAdapter();
            }
            public Object caseSVGBusinessProcessItem(SVGBusinessProcessItem object) {
                return createSVGBusinessProcessItemAdapter();
            }
            public Object caseTDQItem(TDQItem object) {
                return createTDQItemAdapter();
            }
            public Object caseLinkRulesItem(LinkRulesItem object) {
                return createLinkRulesItemAdapter();
            }
            public Object caseItemRelations(ItemRelations object) {
                return createItemRelationsAdapter();
            }
            public Object caseItemRelation(ItemRelation object) {
                return createItemRelationAdapter();
            }
            public Object defaultCase(EObject object) {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    public Adapter createAdapter(Notifier target) {
        return (Adapter)modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.Project <em>Project</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.Project
     * @generated
     */
    public Adapter createProjectAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ProjectComponentAuthorisation <em>Project Component Authorisation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ProjectComponentAuthorisation
     * @generated
     */
    public Adapter createProjectComponentAuthorisationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ProjectReference <em>Project Reference</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ProjectReference
     * @generated
     */
    public Adapter createProjectReferenceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.Status <em>Status</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.Status
     * @generated
     */
    public Adapter createStatusAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ItemState <em>Item State</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ItemState
     * @generated
     */
    public Adapter createItemStateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.Property <em>Property</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.Property
     * @generated
     */
    public Adapter createPropertyAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.Item
     * @generated
     */
    public Adapter createItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.LinkDocumentationItem <em>Link Documentation Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.LinkDocumentationItem
     * @generated
     */
    public Adapter createLinkDocumentationItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.LinkType <em>Link Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.LinkType
     * @generated
     */
    public Adapter createLinkTypeAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.BusinessProcessItem <em>Business Process Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.BusinessProcessItem
     * @generated
     */
    public Adapter createBusinessProcessItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.FileItem <em>File Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.FileItem
     * @generated
     */
    public Adapter createFileItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ByteArray <em>Byte Array</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ByteArray
     * @generated
     */
    public Adapter createByteArrayAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.DocumentationItem <em>Documentation Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.DocumentationItem
     * @generated
     */
    public Adapter createDocumentationItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.RoutineItem <em>Routine Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.RoutineItem
     * @generated
     */
    public Adapter createRoutineItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ConnectionItem <em>Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ConnectionItem
     * @generated
     */
    public Adapter createConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SnippetVariable <em>Snippet Variable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SnippetVariable
     * @generated
     */
    public Adapter createSnippetVariableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SnippetItem <em>Snippet Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SnippetItem
     * @generated
     */
    public Adapter createSnippetItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.DelimitedFileConnectionItem <em>Delimited File Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.DelimitedFileConnectionItem
     * @generated
     */
    public Adapter createDelimitedFileConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.PositionalFileConnectionItem <em>Positional File Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.PositionalFileConnectionItem
     * @generated
     */
    public Adapter createPositionalFileConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.RegExFileConnectionItem <em>Reg Ex File Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.RegExFileConnectionItem
     * @generated
     */
    public Adapter createRegExFileConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.CSVFileConnectionItem <em>CSV File Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.CSVFileConnectionItem
     * @generated
     */
    public Adapter createCSVFileConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.DatabaseConnectionItem <em>Database Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.DatabaseConnectionItem
     * @generated
     */
    public Adapter createDatabaseConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SAPConnectionItem <em>SAP Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SAPConnectionItem
     * @generated
     */
    public Adapter createSAPConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.XmlFileConnectionItem <em>Xml File Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.XmlFileConnectionItem
     * @generated
     */
    public Adapter createXmlFileConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.LdifFileConnectionItem <em>Ldif File Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.LdifFileConnectionItem
     * @generated
     */
    public Adapter createLdifFileConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ExcelFileConnectionItem <em>Excel File Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ExcelFileConnectionItem
     * @generated
     */
    public Adapter createExcelFileConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.EbcdicConnectionItem <em>Ebcdic Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.EbcdicConnectionItem
     * @generated
     */
    public Adapter createEbcdicConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ProcessItem <em>Process Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ProcessItem
     * @generated
     */
    public Adapter createProcessItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.UserRole <em>User Role</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.UserRole
     * @generated
     */
    public Adapter createUserRoleAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.User <em>User</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.User
     * @generated
     */
    public Adapter createUserAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.FolderItem <em>Folder Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.FolderItem
     * @generated
     */
    public Adapter createFolderItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.Component <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.Component
     * @generated
     */
    public Adapter createComponentAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.NotationHolder <em>Notation Holder</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.NotationHolder
     * @generated
     */
    public Adapter createNotationHolderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.UserProjectAuthorization <em>User Project Authorization</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.UserProjectAuthorization
     * @generated
     */
    public Adapter createUserProjectAuthorizationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ContextItem <em>Context Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ContextItem
     * @generated
     */
    public Adapter createContextItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SpagoBiServer <em>Spago Bi Server</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SpagoBiServer
     * @generated
     */
    public Adapter createSpagoBiServerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.License <em>License</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.License
     * @generated
     */
    public Adapter createLicenseAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.GenericSchemaConnectionItem <em>Generic Schema Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.GenericSchemaConnectionItem
     * @generated
     */
    public Adapter createGenericSchemaConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.UserModuleAuthorization <em>User Module Authorization</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.UserModuleAuthorization
     * @generated
     */
    public Adapter createUserModuleAuthorizationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.LDAPSchemaConnectionItem <em>LDAP Schema Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.LDAPSchemaConnectionItem
     * @generated
     */
    public Adapter createLDAPSchemaConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SalesforceSchemaConnectionItem <em>Salesforce Schema Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SalesforceSchemaConnectionItem
     * @generated
     */
    public Adapter createSalesforceSchemaConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.DashboardConnection <em>Dashboard Connection</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.DashboardConnection
     * @generated
     */
    public Adapter createDashboardConnectionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ExecutionServer <em>Execution Server</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ExecutionServer
     * @generated
     */
    public Adapter createExecutionServerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ExecutionTask <em>Execution Task</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ExecutionTask
     * @generated
     */
    public Adapter createExecutionTaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ExecutionTaskCmdPrm <em>Execution Task Cmd Prm</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ExecutionTaskCmdPrm
     * @generated
     */
    public Adapter createExecutionTaskCmdPrmAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ExecutionTaskJobPrm <em>Execution Task Job Prm</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ExecutionTaskJobPrm
     * @generated
     */
    public Adapter createExecutionTaskJobPrmAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.TalendTrigger <em>Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.TalendTrigger
     * @generated
     */
    public Adapter createTalendTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.CronTalendTrigger <em>Cron Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.CronTalendTrigger
     * @generated
     */
    public Adapter createCronTalendTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.CronUITalendTrigger <em>Cron UI Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.CronUITalendTrigger
     * @generated
     */
    public Adapter createCronUITalendTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SimpleTalendTrigger <em>Simple Talend Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SimpleTalendTrigger
     * @generated
     */
    public Adapter createSimpleTalendTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ExecutionVirtualServer <em>Execution Virtual Server</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ExecutionVirtualServer
     * @generated
     */
    public Adapter createExecutionVirtualServerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.FileTrigger <em>File Trigger</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.FileTrigger
     * @generated
     */
    public Adapter createFileTriggerAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.FileTriggerMask <em>File Trigger Mask</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.FileTriggerMask
     * @generated
     */
    public Adapter createFileTriggerMaskAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.JobletProcessItem <em>Joblet Process Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.JobletProcessItem
     * @generated
     */
    public Adapter createJobletProcessItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.JobDocumentationItem <em>Job Documentation Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.JobDocumentationItem
     * @generated
     */
    public Adapter createJobDocumentationItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.JobletDocumentationItem <em>Joblet Documentation Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.JobletDocumentationItem
     * @generated
     */
    public Adapter createJobletDocumentationItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.WSDLSchemaConnectionItem <em>WSDL Schema Connection Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.WSDLSchemaConnectionItem
     * @generated
     */
    public Adapter createWSDLSchemaConnectionItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SchemaInformation <em>Schema Information</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SchemaInformation
     * @generated
     */
    public Adapter createSchemaInformationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.Information <em>Information</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.Information
     * @generated
     */
    public Adapter createInformationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SQLPatternItem <em>SQL Pattern Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SQLPatternItem
     * @generated
     */
    public Adapter createSQLPatternItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ComponentSetting <em>Component Setting</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ComponentSetting
     * @generated
     */
    public Adapter createComponentSettingAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.StatAndLogsSettings <em>Stat And Logs Settings</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.StatAndLogsSettings
     * @generated
     */
    public Adapter createStatAndLogsSettingsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ImplicitContextSettings <em>Implicit Context Settings</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ImplicitContextSettings
     * @generated
     */
    public Adapter createImplicitContextSettingsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SoaOperation <em>Soa Operation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SoaOperation
     * @generated
     */
    public Adapter createSoaOperationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SoaInputParameter <em>Soa Input Parameter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SoaInputParameter
     * @generated
     */
    public Adapter createSoaInputParameterAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SoaService <em>Soa Service</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SoaService
     * @generated
     */
    public Adapter createSoaServiceAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.RulesItem <em>Rules Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.RulesItem
     * @generated
     */
    public Adapter createRulesItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.UserRight <em>User Right</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.UserRight
     * @generated
     */
    public Adapter createUserRightAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.RoleRight <em>Role Right</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.RoleRight
     * @generated
     */
    public Adapter createRoleRightAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.SVGBusinessProcessItem <em>SVG Business Process Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.SVGBusinessProcessItem
     * @generated
     */
    public Adapter createSVGBusinessProcessItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.TDQItem <em>TDQ Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.TDQItem
     * @generated
     */
    public Adapter createTDQItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.LinkRulesItem <em>Link Rules Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.LinkRulesItem
     * @generated
     */
    public Adapter createLinkRulesItemAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ItemRelations <em>Item Relations</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ItemRelations
     * @generated
     */
    public Adapter createItemRelationsAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.ItemRelation <em>Item Relation</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.ItemRelation
     * @generated
     */
    public Adapter createItemRelationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.talend.core.model.properties.TaskExecutionHistory <em>Task Execution History</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.talend.core.model.properties.TaskExecutionHistory
     * @generated
     */
    public Adapter createTaskExecutionHistoryAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //PropertiesAdapterFactory
