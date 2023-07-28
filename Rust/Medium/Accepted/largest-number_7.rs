impl Solution {
    pub fn largest_number(nums: Vec<i32>) -> String {
        

        let mut nums = nums;
        nums.sort_by(|a, b| {
            let sa = a.to_string();
            let sb = b.to_string();
            let ab = sa.clone() + &sb;
            let ba = sb + &sa;
            ab.cmp(&ba).reverse()
        });
        let mut ans = nums.iter().map(|x| x.to_string()).collect::<Vec<String>>().join("");
        while ans.starts_with('0') && ans.len() > 1 {
            ans.remove(0);
        }
        ans
    }
}