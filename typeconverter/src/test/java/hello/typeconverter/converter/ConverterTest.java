package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterTest {

    @Test
    void stringToInteger() throws Exception {
        //given
        StringToIntegerConverter converter = new StringToIntegerConverter();
        //when
        Integer result = converter.convert("10");
        //then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void IntegerToString() {
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void StringToIpPort() throws Exception {
        //given
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String s = "127.0.0.1:8080";
        //when
        IpPort ipPort = converter.convert(s);
        //then
        assertThat(ipPort.getIp()).isEqualTo("127.0.0.1");
        assertThat(ipPort.getPort()).isEqualTo(8080);
    }

    @Test
    void IpPortToString() throws Exception {
        //given
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        
        //when
        String result = converter.convert(ipPort);
        //then
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }
}