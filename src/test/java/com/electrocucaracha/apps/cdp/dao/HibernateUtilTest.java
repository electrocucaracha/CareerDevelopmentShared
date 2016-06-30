package com.electrocucaracha.apps.cdp.dao;

import java.io.FileNotFoundException;

import org.hibernate.boot.MetadataSources;
import org.hibernate.internal.util.config.ConfigurationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(HibernateUtil.class)
public class HibernateUtilTest {

	@Test(expected = ConfigurationException.class)
	public void validateFailedSessionFactoryCreation() throws Exception {
		PowerMockito.whenNew(MetadataSources.class).withAnyArguments().thenThrow(new FileNotFoundException());
		HibernateUtil.getSessionFactory();
	}
}
