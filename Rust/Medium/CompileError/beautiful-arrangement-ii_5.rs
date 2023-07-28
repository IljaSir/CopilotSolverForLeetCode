impl Solution {
    pub fn construct_array(n: i32, k: i32) -> Vec<i32> {
        

        let mut res = vec![];
        let (mut i, mut j) = (1, n);
        while i <= j {
            if k % 2 == 1 {
                res.push(i);
                i += 1;
            } else {
                res.push(j);
                j -= 1;
            }
            if k > 1 {
                k -= 1;
            }
        }
        res
    }
}