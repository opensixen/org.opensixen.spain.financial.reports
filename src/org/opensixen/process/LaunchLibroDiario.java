/**
 * 
 */
package org.opensixen.process;

import org.compiere.process.SvrProcess;
import org.opensixen.osgi.interfaces.ICommand;
import org.opensixen.spain.financial.reports.ReportLibroDiario;
import org.opensixen.spain.financial.reports.ReportSumasYSaldos;

/**
 * @author harlock
 *
 */
public class LaunchLibroDiario extends SvrProcess implements ICommand{

private ReportLibroDiario report;
	
	/* (non-Javadoc)
	 * @see org.compiere.process.SvrProcess#prepare()
	 */
	@Override
	public void prepare() {
		report = new ReportLibroDiario();
		report.prepare();
	}

	/* (non-Javadoc)
	 * @see org.compiere.process.SvrProcess#doIt()
	 */
	@Override
	public String doIt() throws Exception {
		return report.doIt();		
	}

}
