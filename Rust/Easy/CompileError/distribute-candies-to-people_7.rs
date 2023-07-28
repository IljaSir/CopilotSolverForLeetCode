impl Solution {
    pub fn distribute_candies(candies: i32, num_people: i32) -> Vec<i32> {
        
        let mut ans = vec![0; num_people as usize];
        let mut i = 0;
        let mut c = 1;
        while candies > 0 {
            ans[i] += if candies >= c { c } else { candies };
            candies -= c;
            c += 1;
            i = (i + 1) % num_people as usize;
        }
        ans
    }
}