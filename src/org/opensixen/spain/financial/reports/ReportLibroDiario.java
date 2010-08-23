/**
 * 
 */
package org.opensixen.spain.financial.reports;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.compiere.model.PO;
import org.compiere.util.Env;
import org.opensixen.model.ColumnDefinition;
import org.opensixen.model.I_V_Fact_Acct;
import org.opensixen.model.MVFactAcct;
import org.opensixen.model.QParam;
import org.opensixen.osgi.interfaces.ICommand;
import org.opensixen.report.AbstractDynamicReport;
import org.opensixen.report.AbstractPODynamicReport;
import org.opensixen.report.GroupDefinition;
import org.opensixen.report.GroupVariable;

import ar.com.fdvs.dj.domain.DJCalculation;

/**
 * @author harlock
 * 
 */
public class ReportLibroDiario extends AbstractPODynamicReport
		implements ICommand {

	/**
	 * @param ctx
	 */
	protected ReportLibroDiario(Properties ctx) {
		super(ctx);
	}

	
	/**
	 * @param ctx
	 */
	public ReportLibroDiario() {
		super(Env.getCtx());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opensixen.report.AbstractDynamicJasperReport#getColumns()
	 */
	@Override
	protected ColumnDefinition[] getColumns() {
		ColumnDefinition[] cols = {
				new ColumnDefinition(I_V_Fact_Acct.COLUMNNAME_JournalNo, 80),
				new ColumnDefinition(I_V_Fact_Acct.COLUMNNAME_DateAcct, 100 ),
				new ColumnDefinition(I_V_Fact_Acct.COLUMNNAME_Name, 180),
				new ColumnDefinition(I_V_Fact_Acct.COLUMNNAME_Description, 300),
				new ColumnDefinition(I_V_Fact_Acct.COLUMNNAME_Debe, 150),
				new ColumnDefinition(I_V_Fact_Acct.COLUMNNAME_Haber, 150) };
		return cols;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opensixen.report.AbstractDynamicJasperReport#getTitle()
	 */
	@Override
	public String getTitle() {
		return "Libro Diario";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opensixen.report.AbstractDynamicJasperReport#getReportClass()
	 */
	@Override
	protected Class<MVFactAcct> getReportClass() {
		return MVFactAcct.class;
	}

	
	
	
	/* (non-Javadoc)
	 * @see org.opensixen.report.AbstractPODynamicReport#getQParams()
	 */
	@Override
	protected QParam[] getQParams() {
		QParam[] params = {new QParam(MVFactAcct.COLUMNNAME_AD_Client_ID, Env.getAD_Client_ID(getCtx()))};
		return params;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see org.compiere.process.SvrProcess#getCtx()
	 */
	@Override
	public Properties getCtx() {
		return Env.getCtx();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opensixen.report.AbstractDynamicJasperReport#getGroupDefinitions()
	 */
	@Override
	protected List<GroupDefinition> getGroupDefinitions() {
		ArrayList<GroupDefinition> definitions = new ArrayList<GroupDefinition>();

		// Agrupamos por numero de asiento
		GroupDefinition def = new GroupDefinition();
		String[] columns = { I_V_Fact_Acct.COLUMNNAME_JournalNo };
		GroupVariable[] footer = {
				new GroupVariable(I_V_Fact_Acct.COLUMNNAME_Debe, DJCalculation.SUM),
				new GroupVariable(I_V_Fact_Acct.COLUMNNAME_Haber,
						DJCalculation.SUM) };
		def.setGroupColumns(columns);
		def.setFooterVariables(footer);
		definitions.add(def);
		return definitions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opensixen.report.AbstractDynamicJasperReport#getOrderColumns()
	 */
	@Override
	protected String[] getOrderColumns() {
		String[] order = { I_V_Fact_Acct.COLUMNNAME_JournalNo };
		return order;
	}


	/* (non-Javadoc)
	 * @see org.opensixen.osgi.interfaces.ICommand#prepare()
	 */
	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see org.opensixen.osgi.interfaces.ICommand#doIt()
	 */
	@Override
	public String doIt() throws Exception {
		initReport();
		viewReport();
		return null;
	}


}
