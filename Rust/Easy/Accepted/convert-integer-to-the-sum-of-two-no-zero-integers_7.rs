impl Solution {
    pub fn get_no_zero_integers(n: i32) -> Vec<i32> {
        
        let mut i = 1;
        while i < n {
            if !i.to_string().contains("0") && !(n - i).to_string().contains("0") {
                return vec![i, n - i];
            }
            i += 1;
        }
        return vec![];
    }
}