impl Solution {
    pub fn min_number_of_hours(initial_energy: i32, initial_experience: i32, energy: Vec<i32>, experience: Vec<i32>) -> i32 {
        
        let mut min = std::i32::MAX;
        let mut max = 0;
        for i in 0..energy.len() {
            if experience[i] > max {
                max = experience[i];
            }
            if energy[i] > min {
                min = energy[i];
            }
        }
        let mut left = 0;
        let mut right = max - initial_experience + min - initial_energy;
        while left <= right {
            let mid = (left + right) / 2;
            let mut current_energy = initial_energy + mid;
            let mut current_experience = initial_experience + mid;
            let mut flag = true;
            for i in 0..energy.len() {
                if energy[i] > current_energy || experience[i] > current_experience {
                    flag = false;
                    break;
                } else {
                    current_energy -= energy[i];
                    current_experience += experience[i];
                }
            }
            if flag {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left
    }
}