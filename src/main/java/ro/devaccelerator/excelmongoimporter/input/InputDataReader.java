/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.devaccelerator.excelmongoimporter.input;

/**
 *
 * @author bogdan
 */
public interface InputDataReader {
	Boolean readNext();
	InputData getData();
}
