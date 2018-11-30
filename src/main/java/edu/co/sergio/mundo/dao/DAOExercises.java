/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Exercises;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabian.giraldo
 */
public class DAOExercises implements IBaseDatos<Exercises> {

    @Override
    public List<Exercises> findAll() {
        List<Exercises> Exercises = null;
        String query = "SELECT * FROM EXERCISE";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOExercises.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;
            String cat = null;
            String topict = null;
            int macpt = 0;

            while (rs.next()) {
                if (Exercises == null) {
                    Exercises = new ArrayList<Exercises>();
                }

                Exercises registro = new Exercises();

                cat= rs.getString("CAT");
                registro.setCat(cat);

                id = rs.getInt("ENO");
                registro.setEno(id);

                topict = rs.getString("TOPIC");
                registro.setTopic(topict);

               macpt = rs.getInt("MAXPT");
                registro.setMaxtPt(macpt);

                Exercises .add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return  Exercises ;

    }

    @Override
    public boolean insert(Exercises t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Exercises t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Exercises t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
