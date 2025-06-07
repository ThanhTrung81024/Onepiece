package hus.oop.countryarraymanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static CountryArrayManager countryArrayManager = new CountryArrayManager();

    public static void main(String[] args) {
        /* TODO */
        // Viết code cho các hàm test.
        // Kết quả chạy chương trình lưu vào file <Mã số sinh viên>CountryListManager.txt và nộp cùng source code.
        testSortIncreasingByGdp();
    }

    public static void readArrayData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            //dataReader = new BufferedReader(new FileReader("data/nations1.csv"));
            dataReader = new BufferedReader(new FileReader(filePath));

            // How to read file in java line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 6) {
                    continue;
                }

                if (dataList.get(0).equals("code")) {
                    continue;
                }

                // Parse data and create CountryData objects
                CountryData newCountryData = new CountryData(dataList.get(0))
                        .setName(dataList.get(1))
                        .setPopulation(Integer.parseInt(dataList.get(2)))
                        .setArea(Double.parseDouble(dataList.get(3)))
                        .setGdp(Double.parseDouble(dataList.get(4)))
                        .setContinent(dataList.get(5));
                countryArrayManager.append(newCountryData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void init() {
        String filePath = "data/countries1.csv";
        readArrayData(filePath);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA GBR ITA ARG DZA CAN AUS KAZ SGP DNK NLD ESP SWE THA UKR VNM CHE QAT NZL]
    public static void testOriginalData() {
        init();
        String codes = countryArrayManager.codeOfCountriesToString(countryArrayManager.getCountryDataArray(), countryArrayManager.getLength());
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA GBR ITA ARG DZA CAN AUS KAZ SGP DNK NLD ESP SWE THA UKR VNM CHE QAT NZL]
    public static void testSortIncreasingByPopulation() {
        init();
        CountryData[] countries = countryArrayManager.sortIncreasingByPopulation();
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA GBR ITA ARG DZA CAN AUS KAZ SGP DNK NLD ESP SWE THA UKR VNM CHE QAT NZL]
    public static void testSortDecreasingByPopulation() {
        /* TODO */
        init();
        CountryData[] countries = countryArrayManager.sortDecreasingByPopulation();
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA GBR ITA ARG DZA CAN AUS KAZ SGP DNK NLD ESP SWE THA UKR VNM CHE QAT NZL]
    public static void testSortIncreasingByArea() {
        /* TODO */
        init();
        CountryData[] countries = countryArrayManager.sortIncreasingByArea();
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA GBR ITA ARG DZA CAN AUS KAZ SGP DNK NLD ESP SWE THA UKR VNM CHE QAT NZL]
    public static void testSortDecreasingByArea() {
        /* TODO */
        init();
        CountryData[] countries = countryArrayManager.sortDecreasingByArea();
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA GBR ITA ARG DZA CAN AUS KAZ SGP DNK NLD ESP SWE THA UKR VNM CHE QAT NZL]
    public static void testSortIncreasingByGdp() {
        /* TODO */
        init();
        CountryData[] countries = countryArrayManager.sortIncreasingByGdp();
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA GBR ITA ARG DZA CAN AUS KAZ SGP DNK NLD ESP SWE THA UKR VNM CHE QAT NZL]
    public static void testSortDecreasingByGdp() {
        /* TODO */
        init();
        CountryData[] countries = countryArrayManager.sortDecreasingByGdp();
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA GBR ITA ARG DZA CAN AUS KAZ SGP DNK NLD ESP SWE THA UKR VNM CHE QAT NZL]
    public static void testFilterContinent() {
        /* TODO */
        init();
        String continent = "Asia"; // Example continent
        CountryData[] countries = countryArrayManager.filterContinent(continent);
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA]
    public static void testFilterMostPopulousCountries() {
        /* TODO */
        init();
        int n = 10;
        CountryData[] countries = countryArrayManager.filterMostPopulousCountries(n);
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA]
    public static void testFilterLeastPopulousCountries() {
        /* TODO */
        init();
        int n = 10; // Example number of countries
        CountryData[] countries = countryArrayManager.filterLeastPopulousCountries(n);
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA]
    public static void testFilterLargestAreaCountries() {
        /* TODO */
        init();
        int n = 10; // Example number of countries
        CountryData[] countries = countryArrayManager.filterLargestAreaCountries(n);
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA]
    public static void testFilterSmallestAreaCountries() {
        /* TODO */
        init();
        int n = 10; // Example number of countries
        CountryData[] countries = countryArrayManager.filterSmallestAreaCountries(n);
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA]
    public static void testFilterHighestGdpCountries() {
        /* TODO */
        init();
        int n = 10; // Example number of countries
        CountryData[] countries = countryArrayManager.filterHighestGdpCountries(n);
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }

    // In ra code của các nước theo định dạng, ví dụ
    // [CHN IND USA IDN BRA PAK NGA BGD RUS MEX JPN DEU FRA]
    public static void testFilterLowestGdpCountries() {
        /* TODO */
        init();
        int n = 10; // Example number of countries
        CountryData[] countries = countryArrayManager.filterLowestGdpCountries(n);
        String codes = countryArrayManager.codeOfCountriesToString(countries, countries.length);
        System.out.print(codes);
    }
}
