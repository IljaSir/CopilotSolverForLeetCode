impl Solution {
    pub fn next_greater_element(n: i32) -> i32 {
        

        let mut s = n.to_string().into_bytes();
        let mut i = s.len()-1;
        while i > 0 {
            if s[i-1] < s[i] {
                break;
            }
            i -= 1;
        }
        if i == 0 {
            return -1;
        }
        let mut j = s.len()-1;
        while j > i {
            if s[j] > s[i-1] {
                break;
            }
            j -= 1;
        }
        s.swap(i-1, j);
        s[i..].reverse();
        let mut ret = 0;
        for i in 0..s.len() {
            ret = ret * 10 + s[i] as i32 - '0' as i32;
        }
        if ret > i32::MAX as i32 {
            return -1;
        }
        ret
    }
}