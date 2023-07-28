impl Solution {
    pub fn interval_intersection(first_list: Vec<Vec<i32>>, second_list: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut ans = vec![];
        let mut i = 0;
        let mut j = 0;
        while i < first_list.len() && j < second_list.len() {
            let first_start = first_list[i][0];
            let first_end = first_list[i][1];
            let second_start = second_list[j][0];
            let second_end = second_list[j][1];
            let start = first_start.max(second_start);
            let end = first_end.min(second_end);
            if start <= end {
                ans.push(vec![start, end]);
            }
            if first_end < second_end {
                i += 1;
            } else {
                j += 1;
            }
        }
        ans
    }
}