impl Solution {
    pub fn handle_query(nums1: Vec<i32>, nums2: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i64> {
        
        let mut nums1 = nums1;
        let mut nums2 = nums2;
        let mut result = Vec::new();
        for query in queries {
            match query[0] {
                1 => {
                    for i in query[1] as usize..=query[2] as usize {
                        nums1[i] = 1 - nums1[i];
                    }
                },
                2 => {
                    let mut sum = 0;
                    for i in 0..nums1.len() {
                        sum += nums1[i] as i64 * nums2[i] as i64;
                    }
                    result.push(sum * query[1] as i64);
                },
                3 => {
                    let mut sum = 0;
                    for i in 0..nums1.len() {
                        sum += nums2[i] as i64;
                    }
                    result.push(sum);
                },
                _ => (),
            }
        }
        result
    }
}