package Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JComboBox;

public class CargarComboBox {
	//public Vector <ClassTipoProducto> categorias;
	//public Vector <Comprobante> comprobante;
	public Vector<ClassTipoUsuario> vectorTipoUsuario;
	public Vector<ClassCiudades> vectorCiudades;
	public Vector<ClassMarcaProducto> vectorMarcaProducto;
	public Vector<ClassCategoriaProducto> vectorCategoriaPrudcto;
	public Vector<ClassUnidadMedida> vectorUnidadMedida;
	
	
	
	/*public void cargarComboBox(JComboBox cmbTipoAgregarProducto) {//para llenar el comboBox
		
		
			BaseDeDatos conn = new BaseDeDatos();
				categorias = new Vector<>();
				ResultSet rs;
				try {
					rs = (ResultSet) conn.getConexion().createStatement().executeQuery("select ID, Descripcion from tbltipoproducto");
						while (rs.next()){
						ClassTipoProducto categoria = new ClassTipoProducto(rs.getInt(1), rs.getString(2));	
						
						categorias.add(categoria);
						cmbTipoAgregarProducto.addItem(categoria.getDescripcion());
						
						}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}*/
	
	public void cargarComboBoxTipoUsuario(JComboBox<Object> cmbTipoUsuario) {//para llenar el comboBox
		
			vectorTipoUsuario = new Vector<>();
			ResultSet rs;
			try {
				rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery("SELECT idTipoUsuario, descripcion FROM tbltipousuario");
				while (rs.next()){
					ClassTipoUsuario tipoUsuario = new ClassTipoUsuario(rs.getInt(1), rs.getString(2));	
					vectorTipoUsuario.add(tipoUsuario);
					cmbTipoUsuario.addItem(tipoUsuario.getDescripcion());
					}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
	}
	
	public void cargarComboBoxCiudades(JComboBox<Object> cmbCiudades) {//para llenar el comboBox
		
		vectorCiudades= new Vector<>();
		ResultSet rs;
		try {
			rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery("SELECT idCiudad, descripcion FROM tblciudades");
			while (rs.next()){
				ClassCiudades ciudades = new ClassCiudades(rs.getInt(1), rs.getString(2));	
				vectorCiudades.add(ciudades);
				cmbCiudades.addItem(ciudades.getDescripcion());
				
				}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void cargarComboBoxMarcaProducto(JComboBox<Object> cmbMarcaProducto) {//para llenar el comboBox
		
		vectorMarcaProducto= new Vector<>();
		ResultSet rs;
		try {
			rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery("SELECT idMarcaProducto, Descripcion FROM tblmarcaproducto");
			while (rs.next()){
				ClassMarcaProducto marcaProducto = new ClassMarcaProducto(rs.getInt(1), rs.getString(2));	
				vectorMarcaProducto.add(marcaProducto);
				cmbMarcaProducto.addItem(marcaProducto.getDescripcion());
				}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
		
	public void cargarComboBoxCategoriaProducto(JComboBox<Object> cmbCategoriaProducto) {//para llenar el comboBox
		
		vectorCategoriaPrudcto= new Vector<>();
		ResultSet rs;
		try {
			rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery("SELECT idCategoriaProducto, Descripcion FROM tblcategoriaproducto");
			while (rs.next()){
				ClassCategoriaProducto categoriaProducto = new ClassCategoriaProducto(rs.getInt(1), rs.getString(2));	
				vectorCategoriaPrudcto.add(categoriaProducto);
				cmbCategoriaProducto.addItem(categoriaProducto.getDescripcion());
				}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void cargarComboBoxUnidadMedida(JComboBox<Object> cmbUnidadMedida) {//para llenar el comboBox
		
		vectorUnidadMedida= new Vector<>();
		ResultSet rs;
		try {
			rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery("SELECT idUnidadMedida, Descripcion FROM tblunidadmedida");
			while (rs.next()){
				ClassUnidadMedida unidadMedida = new ClassUnidadMedida(rs.getInt(1), rs.getString(2));	
				vectorUnidadMedida.add(unidadMedida);
				cmbUnidadMedida.addItem(unidadMedida.getDescripcion());
				}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}	
	
	
/*public void cargarComboBoxComrobante(JComboBox cmbComprobante) {//para llenar el comboBox
		
		
		BaseDeDatos conn = new BaseDeDatos();
			comprobante = new Vector<>();
			ResultSet rs;
			try {
				rs = (ResultSet) conn.getConexion().createStatement().executeQuery("select idcomprobante, descripcion from tblcomprobante");
					while (rs.next()){
					Comprobante numComprobante = new Comprobante(rs.getInt(1), rs.getString(2));	
					
					comprobante.add(numComprobante);
					cmbComprobante.addItem(numComprobante.getDescripcionComprobante());
					
					}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}*/

}
