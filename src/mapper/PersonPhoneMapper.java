package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PersonPhoneModel;

/**
 *
 * @author ACER
 */
public class PersonPhoneMapper implements RowMapper<PersonPhoneModel>{

    @Override
    public PersonPhoneModel mapRow(ResultSet rs) {
            PersonPhoneModel personPhoneModel = new PersonPhoneModel();
        try {
            personPhoneModel.setSsn(rs.getString("ssn"));
            personPhoneModel.setPhone(rs.getString("phone"));
        } catch (SQLException ex) {
            Logger.getLogger(PersonPhoneMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personPhoneModel;
    }
    
}
