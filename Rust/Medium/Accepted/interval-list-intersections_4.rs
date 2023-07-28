impl Solution {
    pub fn interval_intersection(first_list: Vec<Vec<i32>>, second_list: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut result = vec![];
        let mut i = 0;
        let mut j = 0;
        while i < first_list.len() && j < second_list.len() {
            let first = &first_list[i];
            let second = &second_list[j];
            let start = first[0].max(second[0]);
            let end = first[1].min(second[1]);
            if start <= end {
                result.push(vec![start, end]);
            }
            if first[1] < second[1] {
                i += 1;
            } else {
                j += 1;
            }
        }
        result
    }
}