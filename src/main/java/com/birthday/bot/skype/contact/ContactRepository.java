package com.birthday.bot.skype.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Repository for storing all skype ContactWithBDay from company
 * Created by Vsevolod on 22.02.2016.
 */
public class ContactRepository {

    private static class SingletonHolder {
        private static final ContactRepository instance = ContactRepositoryFactory.create();
    }

    public static ContactRepository getInstance () {
        return SingletonHolder.instance;
    }

    private final Map<String, ContactWithBDay> contacts;

    public ContactRepository(final Map<String, ContactWithBDay> users) {
        this.contacts = users;
    }

    public Map<String, ContactWithBDay> getAllContactWithBDays() {
        return contacts;
    }

    public void addUser(final ContactWithBDay contactWithBDay) {
        contacts.put(contactWithBDay.getUsername(), contactWithBDay);
    }

    public synchronized void addContactWithBDays(final Map<String, ContactWithBDay> contactWithBDays) {
        contacts.entrySet().addAll(contactWithBDays.entrySet());
    }

    public ContactWithBDay getContactWithBDay(final String login) {
        return contacts.get(login);
    }

    /**
     * @param pUsers which are need excluded
     * @return all users from repository instead pUsers
     */
    public List<ContactWithBDay> getUsersWithout(final List<ContactWithBDay> pUsers) {
        List<ContactWithBDay> tUsers = new ArrayList<ContactWithBDay>(contacts.values());
        tUsers.removeAll(pUsers);
        return tUsers;
    }
}
