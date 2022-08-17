package hello.typeconverter.formatter;


import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() throws Exception {
        //given
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addFormatter(new MyNumberFormatter());
        //when
        String ipString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        //then
        assertThat(ipString).isEqualTo("127.0.0.1:8080");
        assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
    }
}
