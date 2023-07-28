impl Solution {
    pub fn least_interval(tasks: Vec<char>, n: i32) -> i32 {
        

        let mut count = vec![0; 26];
        for c in tasks {
            count[(c as u8 - b'A') as usize] += 1;
        }
        count.sort_by(|a, b| b.cmp(a));
        let mut max_val = count[0];
        let mut max_count = 1;
        for i in 1..26 {
            if count[i] == max_val {
                max_count += 1;
            } else {
                break;
            }
        }
        let mut ans = (max_val - 1) * (n + 1) + max_count;
        if ans < tasks.len() as i32 {
            ans = tasks.len() as i32;
        }
        ans
    }
}