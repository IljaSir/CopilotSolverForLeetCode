impl Solution {
    pub fn construct_array(n: i32, k: i32) -> Vec<i32> {
        

        let mut ans = Vec::with_capacity(n as usize);
        let mut i = 1;
        let mut j = n;
        while i <= j {
            if k % 2 == 1 {
                ans.push(i);
                i += 1;
            } else {
                ans.push(j);
                j -= 1;
            }
            if k > 1 {
                k -= 1;
            }
        }
        ans
    }
}