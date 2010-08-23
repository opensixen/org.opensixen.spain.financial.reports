/**
 * 
 */
package org.opensixen.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author harlock
 *
 */
public class MVFactAcct extends X_V_Fact_Acct {

	public MVFactAcct(Properties ctx, int V_Fact_Acct_ID, String trxName) {
		super(ctx, V_Fact_Acct_ID, trxName);
	}

	public MVFactAcct(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	
	
}
