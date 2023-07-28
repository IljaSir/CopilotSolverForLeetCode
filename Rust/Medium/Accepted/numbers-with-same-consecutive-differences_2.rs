impl Solution {
    pub fn nums_same_consec_diff(n: i32, k: i32) -> Vec<i32> {
        
        let mut ans = vec![];
        for i in 1..10 {
            ans.push(i);
        }
        for _ in 1..n {
            let mut next = vec![];
            for i in ans {
                let last = i % 10;
                if last + k < 10 {
                    next.push(i * 10 + last + k);
                }
                if k != 0 && last - k >= 0 {
                    next.push(i * 10 + last - k);
                }
            }
            ans = next;
        }
        if n == 1 {
            ans.push(0);
        }
        ans
    }
}