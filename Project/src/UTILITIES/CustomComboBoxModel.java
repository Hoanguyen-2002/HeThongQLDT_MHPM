
package UTILITIES;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;


public class CustomComboBoxModel extends DefaultComboBoxModel {

    public CustomComboBoxModel() {
    }

    public CustomComboBoxModel(Object[] items) {
        super(items);
    }

    public CustomComboBoxModel(Vector v) {
        super(v);
    }

    public CustomComboBoxModel(ResultSet rs, String ValueMember, String DisplayMember) throws SQLException {
        while (rs.next()) {
            this.addElement(new ItemComboBoxModel(rs.getObject(DisplayMember), rs.getObject(ValueMember)));
        }
    }

    //Bổ sung thêm phương thức setSelectedValueItem() nhận vào một valueMember 
    //giá trị đang hiển thị cũng sẽ thay đổi phù hợp với key (hay valueMember) được truyền vào phương thức này
    public void setSelectedValueItem(Object newSelectedValue) {
        for (int i = 0; i < this.getSize(); i++) {
            ItemComboBoxModel item = (ItemComboBoxModel) this.getElementAt(i);
            if (newSelectedValue.equals(item.valueMember)) {
                this.setSelectedItem(item);
                break;
            }
        }
    }

    //Bổ sung thêm phương thức getSelectedValueItem()  
    //Phương thức này trả về key(hay valueMember) ứng với giá trị đang hiển thị trên JComboBox
    public Object getSelectedValueItem() {
        ItemComboBoxModel selectedItem = (ItemComboBoxModel) this.getSelectedItem();
        return selectedItem.valueMember;
    }

    //Định nghĩa một nested class biểu diễn cho các đối tượng Item được lưu trong JComboBox
    //Đối tượng Item gồm hai thành phần dữ liệu: một dể lưu giá trị được sử dụng để hiện thị trên JComboBox là displayMember
    //và một để lưu key tương ứng với giá trị đang hiển thị trên JComboBox là valueMember
    //Ghi đè phương thức toString(): phương thức trả về giá trị của displayMember ở dạng chuỗi, làm như vậy để
    //giá trị của nó được hiển thị    
    private class ItemComboBoxModel {

        private Object displayMember;
        private Object valueMember;

        public ItemComboBoxModel(Object display, Object value) {
            displayMember = display;
            valueMember = value;
        }

        @Override
        public String toString() {
            return displayMember.toString();
        }
    }
}
