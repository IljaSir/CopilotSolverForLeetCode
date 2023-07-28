impl Solution {
    pub fn maximum_binary_string(binary: String) -> String {
        
        let mut c = 0;
        let mut res = binary.clone();
        for i in 0..binary.len() {
            if binary[i..].starts_with("10") {
                c += 1;
                res = res.replace("10", "01", 1);
            }
        }
        if c == 0 {
            return binary;
        }
        let mut p = binary.len() - c - 1;
        let mut s = res.clone();
        while p < binary.len() - 1 {
            s = s.replace("01", "10", 1);
            p += 1;
        }
        return s;
    }
}