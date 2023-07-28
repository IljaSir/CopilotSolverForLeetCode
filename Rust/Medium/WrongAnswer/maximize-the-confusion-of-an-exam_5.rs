impl Solution {
    pub fn max_consecutive_answers(answer_key: String, k: i32) -> i32 {
        
        let mut ans = 0;
        let n = answer_key.len();
        let mut l = 0;
        let mut r = 0;
        let mut tf = 0;
        let mut ft = 0;
        let mut max_tf = 0;
        let mut max_ft = 0;
        while r < n {
            if answer_key.as_bytes()[r] == b'T' {
                tf += 1;
            } else {
                ft += 1;
            }
            max_tf = max_tf.max(tf);
            max_ft = max_ft.max(ft);
            while tf - max_tf > k {
                if answer_key.as_bytes()[l] == b'T' {
                    tf -= 1;
                }
                l += 1;
            }
            while ft - max_ft > k {
                if answer_key.as_bytes()[l] == b'F' {
                    ft -= 1;
                }
                l += 1;
            }
            ans = ans.max(tf).max(ft);
            r += 1;
        }
        ans as i32
    }
}