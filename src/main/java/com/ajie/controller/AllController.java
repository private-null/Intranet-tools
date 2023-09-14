package com.ajie.controller;



import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class AllController {
    @FXML
    private TextArea w_m_area;


    @FXML
    private TextField w_m_cmd;

    @FXML
    private TextField w_m_ip;

    @FXML
    private TextField w_m_pass;

    @FXML
    private TextField w_m_user;

    @FXML
    private TextArea w_h_area;

    @FXML
    private TextField w_h_cmd;

    @FXML
    private TextField w_h_hash;

    @FXML
    private TextField w_h_ip;

    @FXML
    private TextField w_h_user;

    @FXML
    private TextArea p_m_area;

    @FXML
    private TextField p_m_cmd;

    @FXML
    private TextField p_m_ip;

    @FXML
    private TextField p_m_pass;

    @FXML
    private TextField p_m_user;

    @FXML
    private TextArea p_h_area;

    @FXML
    private TextField p_h_cmd;

    @FXML
    private TextField p_h_hash;

    @FXML
    private TextField p_h_ip;

    @FXML
    private TextField p_h_user;

    @FXML
    private TextField s_h_cmd;

    @FXML
    private TextField s_h_hash;

    @FXML
    private TextField s_h_ip;

    @FXML
    private TextArea s_h_srea;

    @FXML
    private TextField s_h_user;

    @FXML
    private TextArea s_m_area;

    @FXML
    private TextField s_m_cmd;

    @FXML
    private TextField s_m_ip;

    @FXML
    private TextField s_m_pass;

    @FXML
    private TextField s_m_user;

    @FXML
    private TextArea a_h_area;

    @FXML
    private TextField a_h_cmd;

    @FXML
    private TextField a_h_hash;

    @FXML
    private TextField a_h_ip;

    @FXML
    private TextField a_h_user;

    @FXML
    private TextArea a_m_area;

    @FXML
    private TextField a_m_cmd;

    @FXML
    private TextField a_m_ip;

    @FXML
    private TextField a_m_pass;

    @FXML
    private TextField a_m_user;

    @FXML
    private TextArea d_h_area;


    @FXML
    private TextField d_h_cmd;

    @FXML
    private TextField d_h_hash;

    @FXML
    private TextField d_h_ip;

    @FXML
    private TextField d_h_user;

    @FXML
    private TextArea d_m_area;

    @FXML
    private TextField d_m_cmd;

    @FXML
    private TextField d_m_ip;

    @FXML
    private TextField d_m_pass;

    @FXML
    private TextField d_m_user;


    @FXML
    void m_attack(MouseEvent event) {
        new com.ajie.controller.wmiexec.CiphermodeController(w_m_area,w_m_cmd,w_m_ip,w_m_pass,w_m_user);
    }


    @FXML
    void m_clear(MouseEvent event) {
        w_m_area.clear();
    }


    @FXML
    void w_h_attack(MouseEvent event) {
        new com.ajie.controller.wmiexec.HashmodeController(w_h_area, w_h_cmd, w_h_ip,  w_h_hash,  w_h_user);

    }

    @FXML
    void w_h_clear(MouseEvent event) {
        w_h_area.clear();
    }


    @FXML
    void p_m_attack(MouseEvent event) {
        new com.ajie.controller.psexec.CiphermodeController(p_m_area, p_m_cmd, p_m_ip, p_m_pass, p_m_user);
    }

    @FXML
    void p_m_clear(MouseEvent event) {
        p_m_area.clear();
    }

    @FXML
    void p_h_attack(MouseEvent event) {
        new com.ajie.controller.psexec.HashmodeController(p_h_area, p_h_cmd, p_h_ip, p_h_hash, p_h_user);
    }

    @FXML
    void p_h_clear(MouseEvent event) {
        p_h_area.clear();
    }

    @FXML
    void s_h_attack(MouseEvent event) {
        //
    }

    @FXML
    void s_h_clear(MouseEvent event) {
        //
    }

    @FXML
    void s_m_attack(MouseEvent event) {
        //
    }

    @FXML
    void s_m_clear(MouseEvent event) {
        //
    }

    @FXML
    void a_h_attack(MouseEvent event) {
        new com.ajie.controller.ATexec.HashmodeController(a_h_area, a_h_cmd, a_h_ip, a_h_hash, a_h_user);
    }

    @FXML
    void a_h_clear(MouseEvent event) {
        a_h_area.clear();
    }

    @FXML
    void a_m_attack(MouseEvent event) {
        new com.ajie.controller.ATexec.CiphermodeController(a_m_area, a_m_cmd, a_m_ip, a_m_pass, a_m_user);
    }

    @FXML
    void a_m_clear(MouseEvent event) {
        a_m_area.clear();
    }

    @FXML
    void d_m_attack(MouseEvent event) {
        new com.ajie.controller.DCOMexec.CiphermodeController(d_m_area, d_m_cmd, d_m_ip, d_m_pass, d_m_user);
    }

    @FXML
    void d_m_clear(MouseEvent event) {
        d_m_area.clear();
    }
    @FXML
    void d_h_attack(MouseEvent event) {
        new com.ajie.controller.DCOMexec.HashmodeController(d_h_area, d_h_cmd, d_h_ip, d_h_hash, d_h_user);
    }

    @FXML
    void d_h_clear(MouseEvent event) {
        d_h_area.clear();
    }


}
