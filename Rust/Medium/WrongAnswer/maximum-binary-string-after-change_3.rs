impl Solution {
    pub fn maximum_binary_string(binary: String) -> String {
        
        let mut binary = binary;
        let mut i = 0;
        while i < binary.len() {
            let mut j = i;
            while j < binary.len() && binary.as_bytes()[j] == b'1' {
                j += 1;
            }
            if j < binary.len() {
                let mut k = j;
                while k < binary.len() && binary.as_bytes()[k] == b'0' {
                    k += 1;
                }
                if k < binary.len() {
                    binary.replace_range(j..k, "1".repeat(k - j).as_str());
                }
            }
            i = j + 1;
        }
        binary
    }
}