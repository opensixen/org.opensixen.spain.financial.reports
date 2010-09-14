/**
 * 
 */
package org.opensixen.spain.financial.reports;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Properties;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;

import org.compiere.util.Env;
import org.opensixen.model.ColumnDefinition;
import org.opensixen.osgi.interfaces.ICommand;
import org.opensixen.report.AbstractDynamicReport;


/**
 * @author harlock
 *
 */
public class ReportSumasYSaldos extends AbstractDynamicReport implements ICommand {

	/**
	 * @param ctx
	 */
	protected ReportSumasYSaldos(Properties ctx) {
		super(ctx);
	}
	
	public ReportSumasYSaldos() {
		super(Env.getCtx());
	}

	/* (non-Javadoc)
	 * @see org.opensixen.report.AbstractDynamicJasperReport#getColumns()
	 */
	@Override
	protected ColumnDefinition[] getColumns() {
		ColumnDefinition[] cols = { new ColumnDefinition("value", "Cuenta", String.class, 80),
								new ColumnDefinition("name", "", String.class, 240),
								new ColumnDefinition("saldoinicial", "Inicial", BigDecimal.class, 90),
								new ColumnDefinition("debe", "Debe", BigDecimal.class, 90),
								new ColumnDefinition("haber", "Haber", BigDecimal.class, 90),
								new ColumnDefinition("saldo", "saldo", BigDecimal.class, 90)
		};
		
		return cols;
		
	}

	/* (non-Javadoc)
	 * @see org.opensixen.report.AbstractDynamicJasperReport#getTitle()
	 */
	@Override
	public String getTitle() {
		return "Sumas y Saldos";
	}


	/* (non-Javadoc)
	 * @see org.opensixen.report.AbstractDynamicJasperReport#getDataSource()
	 */
	@Override
	protected JRDataSource getDataSource() {
		SumasYSaldosJasperDataSource ds = new SumasYSaldosJasperDataSource(Env.getCtx());
		ds.loadData();
		return ds;
		
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
