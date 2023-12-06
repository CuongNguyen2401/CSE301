package model;

/**
 *
 * @author ACER
 */
public class BranchModel {

    private String branchId;
    private String branchCity;
    private float assets;

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public float getAssets() {
        return assets;
    }

    public void setAssets(float assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "Branch{" + "branchId=" + branchId + ", branchCity=" + branchCity + ", assets=" + assets + '}';
    }
    
}
