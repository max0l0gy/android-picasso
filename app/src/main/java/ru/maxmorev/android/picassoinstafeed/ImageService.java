package ru.maxmorev.android.picassoinstafeed;

public class ImageService {

    private final static String[] UrlStrings = {
            "https://pro2-bar.myportfolio.com/v1/assets/06f075e81c7e33133af6f7426636cc56/f8608823-0a71-4171-aed7-e050bcc2fc32_rw_1920.jpg?h=51cc3943d59828ea7d75df3e6ea7b193",
            "https://pro2-bar.myportfolio.com/v1/assets/06f075e81c7e33133af6f7426636cc56/fa55a96f-b563-4bca-80d4-be80e2b0ec90_rw_1920.jpg?h=bf443e50cee39b3ad90ec59c41abff4c",
            "https://pro2-bar.myportfolio.com/v1/assets/06f075e81c7e33133af6f7426636cc56/37d4fc26-5791-4511-9f2d-ee6d8127a45d_rw_1920.jpg?h=408982fc003e2483ccb5f76bd55e20d3",
            "https://pro2-bar.myportfolio.com/v1/assets/06f075e81c7e33133af6f7426636cc56/1ee2c117-0259-48d8-afc0-ba26f3f3e0e4_rw_1920.jpg?h=48c8f305a3cb9df9d74ea9e7a72b8374",
            "https://pro2-bar.myportfolio.com/v1/assets/06f075e81c7e33133af6f7426636cc56/382a57da-d409-4c76-9a21-02d10d601b09_rw_1920.jpg?h=9c68c5a27b40fd8bdaa4ffc2b1f3d30b",
            "https://pro2-bar.myportfolio.com/v1/assets/06f075e81c7e33133af6f7426636cc56/6d6a06c4-d691-4dcc-86c1-6b81255e315b_rw_1920.jpg?h=8eacb276856712eb2c705491f2252903",
            "https://pro2-bar.myportfolio.com/v1/assets/06f075e81c7e33133af6f7426636cc56/cb07e2fa-f750-4a1e-ac4e-ad5ea4d504df_rw_1920.jpg?h=f6cf6252dd4449746635ea593a8f19c8",
            "https://pro2-bar.myportfolio.com/v1/assets/06f075e81c7e33133af6f7426636cc56/8b326196-a8a0-4229-9824-9abe8a577cf5_rw_1920.jpg?h=655e36cd8239a865d3f422c416403b65",
            "https://pro2-bar.myportfolio.com/v1/assets/06f075e81c7e33133af6f7426636cc56/600af731-2a4b-4a4b-8259-467d3d3ff43d_rw_1920.jpg?h=95d851ac4fa72cf532fc22395b94f021",
            "https://pro2-bar.myportfolio.com/v1/assets/06f075e81c7e33133af6f7426636cc56/ddd82c56-dcad-45a9-a2a9-19b8bf3abc71_rw_1920.jpg?h=3d553e672d180b3912200f834f6aa64b"
    };

    public static int getImagesCount(){
        return UrlStrings.length;
    }

    public static String getImageURL(int index){
        if(index< UrlStrings.length) {
            return UrlStrings[index];
        }else{
            return "";
        }

    }
}
