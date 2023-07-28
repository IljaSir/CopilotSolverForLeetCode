impl Solution {
    pub fn number_of_unique_good_subsequences(binary: String) -> i32 {
        
        let mut a = 0;
        let mut b = 0;
        let mut c = 0;
        for i in binary.chars() {
            if i == '0' {
                c = (a + b + 1) % 1000000007;
            } else {
                b = (a + b + 1) % 1000000007;
            }
            a = c;
        }
        (a + b + 1) as i32 % 1000000007
    }
}