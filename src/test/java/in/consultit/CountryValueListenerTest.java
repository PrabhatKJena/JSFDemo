package in.consultit;

import com.mkyong.CountryBean;
import com.mkyong.CountryValueListener;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FacesContext.class})
public class CountryValueListenerTest {

    @Test
    public void testProcessValueChange() {
        CountryBean countryBean = new CountryBean();
        Map<String, Object> map = new HashMap<>();
        map.put("country", countryBean);

        ValueChangeEvent valueChangeEvent = Mockito.mock(ValueChangeEvent.class);
        Mockito.when(valueChangeEvent.getNewValue()).thenReturn("IN");

        ExternalContext externalContext = mock(ExternalContext.class);
        when(externalContext.getSessionMap()).thenReturn(map);

        FacesContext facesContext = Mockito.mock(FacesContext.class);
        when(facesContext.getExternalContext()).thenReturn(externalContext);
        PowerMockito.mockStatic(FacesContext.class);
        when(FacesContext.getCurrentInstance()).thenReturn(facesContext);

        CountryValueListener countryValueListener = new CountryValueListener();
        countryValueListener.processValueChange(valueChangeEvent);
        Assert.assertEquals(2, countryBean.getStates().size());
    }

}
