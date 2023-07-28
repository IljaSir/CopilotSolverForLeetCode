impl Solution {
    pub fn next_greater_element(n: i32) -> i32 {
        

        let mut n = n.to_string().into_bytes();
        let len = n.len();
        let mut i = len - 1;
        while i > 0 {
            if n[i] > n[i - 1] {
                break;
            }
            i -= 1;
        }
        if i == 0 {
            return -1;
        }
        let mut j = len - 1;
        while j >= i {
            if n[j] > n[i - 1] {
                break;
            }
            j -= 1;
        }
        n.swap(i - 1, j);
        n[i..].reverse();
        let res: i64 = String::from_utf8(n).unwrap().parse().unwrap();
        if res > i32::max_value() as i64 {
            return -1;
        }
        res as i32
    }
}