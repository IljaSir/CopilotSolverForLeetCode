impl Solution {
    pub fn sort_by_bits(arr: Vec<i32>) -> Vec<i32> {
        
        let mut arr = arr;
        arr.sort();
        arr.sort_by(|a, b| {
            let mut a = *a;
            let mut b = *b;
            let mut a_bits = 0;
            let mut b_bits = 0;
            while a > 0 {
                a_bits += a % 2;
                a /= 2;
            }
            while b > 0 {
                b_bits += b % 2;
                b /= 2;
            }
            a_bits.cmp(&b_bits)
        });
        arr
    }
}