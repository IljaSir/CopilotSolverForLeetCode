impl Solution {
    pub fn custom_sort_string(order: String, s: String) -> String {
        
        let mut order = order.into_bytes();
        let mut s = s.into_bytes();
        order.sort();
        s.sort();
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut res = vec![0; s.len()];
        while i < order.len() {
            while j < s.len() && s[j] == order[i] {
                res[k] = s[j];
                j += 1;
                k += 1;
            }
            i += 1;
        }
        while j < s.len() {
            res[k] = s[j];
            j += 1;
            k += 1;
        }
        String::from_utf8(res).unwrap()
    }
}