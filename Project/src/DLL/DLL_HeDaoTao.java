
package DLL;



public class DLL_HeDaoTao {
    DAL_HeDaoTao dAL_HeDaoTao = new DAL_HeDaoTao();

    public ArrayList<DBO_HE_DAO_TAO> getAllHeDaoTao() {
        return dAL_HeDaoTao.getAllHeDaoTao();
    }

    public boolean Insert(DBO_HE_DAO_TAO obj) {
        return dAL_HeDaoTao.Insert(obj);
    }

    public ArrayList<DBO_HE_DAO_TAO> getAllHeDaoTao_dk(String MaHeDaoTao) {
        return dAL_HeDaoTao.getAllHeDaoTao_dk(MaHeDaoTao);
    }

    public boolean Update(DBO_HE_DAO_TAO obj, String dk) {
        return dAL_HeDaoTao.Update(obj, dk);
    }

    public boolean Delete(String MaHeDaoTao) {
        return dAL_HeDaoTao.Delete(MaHeDaoTao);
    }

    public ArrayList<DBO_HE_DAO_TAO> Check_HeDaoTao(String MaHeDaoTao) {
        return dAL_HeDaoTao.Check_HeDaoTao(MaHeDaoTao);
    }
    public boolean Check(String MaHeDaoTao) {
        return dAL_HeDaoTao.Check(MaHeDaoTao);
    }
}
