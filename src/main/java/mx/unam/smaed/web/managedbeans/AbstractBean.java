/*
 * Copyright (c) 2014, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package mx.unam.smaed.web.managedbeans;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class AbstractBean implements Serializable {

    private static final long serialVersionUID = -3375564172975657665L;
    
    protected FacesContext context() {
        return (FacesContext.getCurrentInstance());
    }

    protected void message(String clientId, String key) {
        String text;

        try {
            ResourceBundle bundle = ResourceBundle.getBundle(
                    "mx.unam.smaed.web.messages.messages",
                    context().getViewRoot().getLocale());
            text = bundle.getString(key);
        } catch (Exception e) {
            text = "???" + key + "???";
        }

        context().addMessage(clientId, new FacesMessage(text));
    }

    protected void message(String clientId, String key, Object[] params) {
        String text;

        try {
            ResourceBundle bundle = ResourceBundle.getBundle(
                    "mx.unam.smaed.web.messages.messages",
                    context().getViewRoot().getLocale());
            text = bundle.getString(key);
        } catch (Exception e) {
            text = "???" + key + "???";
        }

        if ((params != null) && (params.length > 0)) {
            text = MessageFormat.format(text, params);
        }

        context().addMessage(clientId, new FacesMessage(text));
    }
}
