import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Task3 {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) args = new String[]{"c://tests.json", "c://values.json"};
        JsonParser parser = new JsonParser();
        try (FileReader reader = new FileReader(args[1]);
             FileReader readerT = new FileReader(args[0]);){
            JsonObject rootJsonObject = (JsonObject) parser.parse(reader);
            Type mapType = new TypeToken<List<DataJson>>(){}.getType();
            List<DataJson> dataJson = new Gson().fromJson(rootJsonObject.get("values"), mapType);
            Map<Long, String> dataJsonMap = new HashMap<Long, String>();
            for (DataJson tempd : dataJson) {
                dataJsonMap.put(tempd.getId(), tempd.getValue());
            }

            JsonObject rootJsonObjectT = (JsonObject) parser.parse(readerT);
            Type mapTypeT = new TypeToken<DataTests>(){}.getType();
            Gson gsonT = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            DataTests dataJsonT = gsonT.fromJson(rootJsonObjectT, mapTypeT);

            setTestResult(dataJsonT.getTests(), dataJsonMap);

            File file = new File(args[1].substring(0, args[1].length()-11) + "report.json");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(dataJsonT, writer);
            writer.flush();
            writer.close();

        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }




    }

    private static void setTestResult(List<DataValues> dataValues, Map<Long, String> resultMap) {
        for (DataValues dataValue : dataValues ) {
            dataValue.setValue(resultMap.get(dataValue.getId()));

            if (dataValue.getValues() != null) {
                setTestResult(dataValue.getValues(), resultMap);
            }
        }
    }
}
