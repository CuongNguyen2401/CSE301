package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BranchModel;

/**
 *
 * @author ACER
 */
public class BranchMapper implements RowMapper<BranchModel>{

    @Override
    public BranchModel mapRow(ResultSet rs) {
        BranchModel branchModel = new BranchModel();
        try {
            branchModel.setBranchId(rs.getInt("branch_id"));
            branchModel.setBranchCity(rs.getString("branch_city"));
            branchModel.setAssets(rs.getFloat("assets"));
        } catch (SQLException ex) {
            Logger.getLogger(BranchMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return branchModel;
    }
    
}
