package UTILITIES;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Vector;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Mr.Minh
 */
public class CustomTableModel extends DefaultTableModel {

    ResultSetMetaData rsMetaData = null;    

    public CustomTableModel() {       
    }

    public CustomTableModel(ResultSet rsData) throws SQLException {
      

        rsMetaData = rsData.getMetaData();     //Lấy MetaData của ResultSet
        int numColumns = rsMetaData.getColumnCount();  //lưu số lượng Field hiện có trong ResultSet


        //Duyệt rsMetaData để lấy ra các tên Field có trong resultSet rsData. Tên lấy được lưu vào vector colHeaders
        for (int i = 1; i <= numColumns; i++) {
            this.addColumn(rsMetaData.getColumnName(i));
        }

        while (rsData.next()) {

            Vector tempRow = new Vector(numColumns);
            for (int i = 0; i < numColumns; i++) {
                switch (rsMetaData.getColumnType(i + 1)) {
                    // mapping kiểu dữ liệu
                    case Types.CHAR:
                    case Types.VARCHAR:
                    case Types.LONGVARCHAR:
                        String s = rsData.getString(i + 1);
                        tempRow.add(s);
                        break;
                    case Types.INTEGER:
                        int in = rsData.getInt(i + 1);
                        if (rsData.wasNull()) {
                            tempRow.add(null);
                        } else {
                            tempRow.add(new Integer(in));
                        }
                        break;
                    case Types.SMALLINT:
                        short sh = rsData.getShort(i + 1);
                        if (rsData.wasNull()) {
                            tempRow.add(null);
                        } else {
                            tempRow.add(new Short(sh));
                        }
                        break;
                    case Types.TINYINT:
                        byte b = rsData.getByte(i + 1);
                        if (rsData.wasNull()) {
                            tempRow.add(null);
                        } else {
                            tempRow.add(new Byte(b));
                        }
                        break;
                    case Types.FLOAT:
                    case Types.DOUBLE:
                        double d = rsData.getDouble(i + 1);
                        if (rsData.wasNull()) {
                            tempRow.add(null);
                        } else {
                            tempRow.add(new Double(d));
                        }
                        break;
                    case Types.REAL:
                        float f = rsData.getFloat(i + 1);
                        if (rsData.wasNull()) {
                            tempRow.add(null);
                        } else {
                            tempRow.add(new Float(f));
                        }
                        break;
                    case Types.BIT:
                        boolean bo = rsData.getBoolean(i + 1);
                        if (rsData.wasNull()) {
                            tempRow.add(null);
                        } else {
                            tempRow.add(new Boolean(bo));
                        }
                        break;
                    case Types.BIGINT:
                        long l = rsData.getLong(i + 1);
                        if (rsData.wasNull()) {
                            tempRow.add(null);
                        } else {
                            tempRow.add(new Long(l));
                        }
                        break;
                    case Types.NUMERIC:
                    case Types.DECIMAL:
                        BigDecimal bd = rsData.getBigDecimal(i + 1);
                        tempRow.add(bd);
                        break;
                    case Types.DATE:
                        java.sql.Date date = rsData.getDate(i + 1);
                        tempRow.add(date);
                        break;
                    case Types.TIMESTAMP:
                        if (Types.DATE == Types.TIMESTAMP) {
                            Timestamp ts = rsData.getTimestamp(i + 1);
                            tempRow.add(ts);
                            break;
                        }
                        if (Types.DATE == Types.TIME) {
                            Time t = rsData.getTime(i + 1);
                            tempRow.add(t);
                            break;
                        }
                        if (Types.DATE == Types.DATE) {
                            java.sql.Date date2 = rsData.getDate(i + 1);
                            tempRow.add(date2);
                            break;
                        }
                    case Types.TIME:
                        Time t2 = rsData.getTime(i + 1);
                        tempRow.add(t2);
                        break;
                    default:
                        Object o = rsData.getObject(i + 1);
                        tempRow.add(o);
                        break;
                }
            } // end for loop
            this.addRow(tempRow);
        } // end while loop
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        try {
            switch (rsMetaData.getColumnType(columnIndex + 1)) {
                case Types.CHAR:
                case Types.VARCHAR:
                case Types.LONGVARCHAR:
                    return String.class;

                case Types.INTEGER:
                    return Integer.class;

                case Types.SMALLINT:
                    return Short.class;

                case Types.TINYINT:
                    return Byte.class;

                case Types.FLOAT:
                case Types.DOUBLE:
                    return Double.class;

                case Types.REAL:
                    return Float.class;

                // There is no boolean datatype in Oracle
                case Types.BIT:
                    return Boolean.class;

                case Types.BIGINT:
                    return Long.class;

                case Types.NUMERIC:
                case Types.DECIMAL:
                    return BigDecimal.class;

                case Types.DATE:
                    return java.sql.Date.class;

                case Types.TIMESTAMP:
                    return (Types.DATE == Types.DATE ? java.sql.Date.class
                            : (Types.DATE == Types.TIMESTAMP ? Timestamp.class : Time.class));
                case Types.TIME:
                    return Time.class;
                default:
                    return Object.class;
            }
        } catch (SQLException ex) {
            return Object.class;
        }

//        Class returnValue;
//        if ((column >= 0) && (column < getColumnCount())) {
//            switch (getValueAt(0, column).getClass() + "") {
//                case "java.sql.Timestamp":
//                    return java.sql.Timestamp.class;
//                case "java.sql.Date":
//                    return java.sql.Date.class;
//                default:
//                    returnValue = getValueAt(0, column).getClass();
//            }
//        } else {
//            returnValue = Object.class;
//        }
//        return returnValue;
    }   
}
