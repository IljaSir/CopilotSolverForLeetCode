impl Solution {
    pub fn add_to_array_form(num: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut k = k;
        let mut result = Vec::new();
        let mut i = num.len();
        while i > 0 || k > 0 {
            i -= 1;
            let mut n = k % 10;
            if i < num.len() {
                n += num[i];
            }
            result.push(n % 10);
            k = k / 10 + n / 10;
        }
        result.reverse();
        result
    }
}