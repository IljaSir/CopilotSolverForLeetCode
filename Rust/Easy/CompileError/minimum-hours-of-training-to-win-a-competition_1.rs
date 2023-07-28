impl Solution {
    pub fn min_number_of_hours(initial_energy: i32, initial_experience: i32, energy: Vec<i32>, experience: Vec<i32>) -> i32 {
        
        let mut energy = energy;
        let mut experience = experience;
        let mut energy = energy.iter().zip(experience.iter()).map(|(e, x)| e - x).collect::<Vec<_>>();
        let mut experience = energy.iter().map(|x| x.abs()).collect::<Vec<_>>();
        let mut energy = energy.iter().map(|x| x.max(&0)).collect::<Vec<_>>();
        energy.sort();
        experience.sort();
        let mut energy = energy.iter().fold(initial_energy, |acc, x| acc + x);
        let mut experience = experience.iter().fold(initial_experience, |acc, x| acc + x);
        let mut i = 0;
        while i < energy.len() && energy[i] <= 0 {
            i += 1;
        }
        if i == energy.len() {
            return 0;
        }
        let mut j = i;
        while j < energy.len() && experience >= 0 {
            experience -= energy[j];
            j += 1;
        }
        j as i32 - i as i32
    }
}