impl Solution {
    pub fn gcd_of_strings(str1: String, str2: String) -> String {
        
        let (mut str1, mut str2) = (str1, str2);
        while str1.len() != str2.len() {
            if str1.len() < str2.len() {
                str2 = str2.replace(&str1, "");
            } else {
                str1 = str1.replace(&str2, "");
            }
        }
        if str1 == str2 {
            str1
        } else {
            "".to_string()
        }
    }
}