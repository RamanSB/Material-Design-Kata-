package com.google.codelabs.mdc.java.shrine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.button.MaterialButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment representing the login screen for Shrine.
 */
public class LoginFragment extends Fragment {


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.shr_login_fragment, container, false);
        MaterialButton nextButton = (MaterialButton) view.findViewById(R.id.next_button);
        MaterialButton cancelButton = (MaterialButton) view.findViewById(R.id.cancel_button);
        final TextInputEditText passwordEditText = (TextInputEditText) view.findViewById(R.id.password_edit_text);
        final TextInputLayout passwordLayoutText = (TextInputLayout) view.findViewById(R.id.password_text_input);

        //Adding click listener to nextButton

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(!isPasswordValid(passwordEditText.getText())){
                    passwordLayoutText.setError(getString(R.string.shr_error_password));
                }else{
                    passwordLayoutText.setError(null);
                    ((NavigationHost) getActivity()).navigateTo(new ProductGridFragment(), false);
                }
            }
        });

        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(isPasswordValid(passwordEditText.getText())){
                    passwordLayoutText.setError(null);
                }
                return false;
            }
        });

        return view;
    }


    private boolean isPasswordValid(Editable passwordText) {
        return passwordText != null && passwordText.length() >= 8;
    }
    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
}
