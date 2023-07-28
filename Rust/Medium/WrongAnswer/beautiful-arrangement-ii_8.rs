impl Solution {
    pub fn construct_array(n: i32, k: i32) -> Vec<i32> {
        

        let mut ans = Vec::new();
        let mut i = 1;
        let mut j = n;
        while i <= j {
            ans.push(i);
            i += 1;
            if i <= j {
                ans.push(j);
                j -= 1;
            }
        }
        let mut v = 1;
        for i in 1..k {
            if v == 1 {
                ans.swap(i as usize, (i + 1) as usize);
            }
            v = 1 - v;
        }
        ans
    }
}