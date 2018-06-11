package com.company.test.staticfactory;

import com.company.test.businessobjects.ClientSiteUser;
import com.company.test.businessobjects.IafUser;

public class UsersStaticFactory {

    public static ClientSiteUser createDefaultClientSiteUser() {
        ClientSiteUser clientSiteUser = new ClientSiteUser();
        clientSiteUser.setUsername("E2029318");
        clientSiteUser.setPassword("password1");
        return clientSiteUser;
    }

    public static IafUser createDefaultIafUser() {
        IafUser iafUser = new IafUser();
        iafUser.setUsername("bhkb.jshcw@gqfozpkzgb.kbk");
        iafUser.setPassword("password1");
        return iafUser;
    }

}
