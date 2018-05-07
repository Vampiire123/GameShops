package com.example.syl.gameshopsmvp.ui.presenter;

import android.content.Context;

import com.example.syl.gameshopsmvp.global.model.Shop;
import com.example.syl.gameshopsmvp.usecase.GetShops;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

public class ShopPresenterTest {

    ShopPresenter shopPresenter;

    @Mock
    Context mockContext;
    @Mock
    GetShops mockGetShops;
    @Mock
    ShopPresenter.View mockView;
    @Mock
    ShopPresenter.Navigator mockNavigator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        shopPresenter = createAMockedPresenter();
    }

    @Test
    public void shouldShowShopsOnSuccess() {
        givenGetShopsListenerSuccess();

        shopPresenter.initialize();

        verify(mockView).showShops(any(List.class));
    }

    @Test
    public void shouldShowErrorOnFailure() {
        givenGetShopsListenerFailure();

        shopPresenter.initialize();

        verify(mockView).showError("Error");
    }

    @Test
    public void shouldNavigateToMapsActivityWithParametersOnShopClicked() {
        Shop shop = new Shop();
        shop.setName("Some name");
        shop.setLatitude(37.000f);
        shop.setLongitude(-3.00087879f);
        shopPresenter.onShopClicked(shop);

        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Float> floatArgumentCaptorLatitude = ArgumentCaptor.forClass(Float.class);
        ArgumentCaptor<Float> floatArgumentCaptorLongitude = ArgumentCaptor.forClass(Float.class);

        verify(mockNavigator).navigateToMap(stringArgumentCaptor.capture(),
                floatArgumentCaptorLongitude.capture(), floatArgumentCaptorLatitude.capture());

        assertEquals(stringArgumentCaptor.getValue(), "Some name");
        assertEquals(floatArgumentCaptorLatitude.getValue(), 37.000f, 0);
        assertEquals(floatArgumentCaptorLongitude.getValue(), -3.00087879f, 0);
    }

    private void givenGetShopsListenerFailure() {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                GetShops.Listener listener = (GetShops.Listener) invocation.getArguments()[0];
                listener.onError("Error");
                return null;
            }
        }).when(mockGetShops).getShops(any(GetShops.Listener.class));
    }

    private void givenGetShopsListenerSuccess() {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                GetShops.Listener listener = (GetShops.Listener) invocation.getArguments()[0];
                listener.onSuccess(new ArrayList<Shop>());
                return null;
            }
        }).when(mockGetShops).getShops(any(GetShops.Listener.class));
    }

    private ShopPresenter createAMockedPresenter() {
        ShopPresenter presenter = new ShopPresenter(mockContext, mockGetShops);
        presenter.setView(mockView);
        presenter.setNavigator(mockNavigator);
        return presenter;
    }
}